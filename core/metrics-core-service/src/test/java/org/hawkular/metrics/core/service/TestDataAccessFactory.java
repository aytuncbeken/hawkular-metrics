/*
 * Copyright 2014-2017 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hawkular.metrics.core.service;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

import org.hawkular.metrics.datetime.DateTimeService;
import org.joda.time.DateTime;

import com.datastax.driver.core.Session;

/**
 * @author Michael Burman
 */
public class TestDataAccessFactory {

    public static DataAccess newInstance(Session session) {
        final CountDownLatch latch = new CountDownLatch(3);
        DataAccessImpl dataAccess = new DataAccessImpl(session) {
            @Override
            void prepareTempStatements(String tableName) {
                super.prepareTempStatements(tableName);
                if (latch.getCount() > 0) {
                    latch.countDown();
                }
            }
        };
        dataAccess.createTempTablesIfNotExists(tableListForTesting())
                .subscribe();
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return dataAccess;
    }

    /**
     * Create few temporary tables for tests
     */
    static Set<Long> tableListForTesting() {
        Set<Long> tempTables = new HashSet<>(2);
        DateTime now = DateTimeService.now.get();
        tempTables.add(now.minusHours(2).getMillis());
        tempTables.add(now.getMillis());
        tempTables.add(now.plusHours(2).getMillis());
        return tempTables;
    }

}
