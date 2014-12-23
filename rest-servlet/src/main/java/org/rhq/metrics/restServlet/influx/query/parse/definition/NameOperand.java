/*
 * Copyright 2014 Red Hat, Inc.
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

package org.rhq.metrics.restServlet.influx.query.parse.definition;

/**
 * @author Thomas Segismont
 */
public class NameOperand implements Operand {
    private final boolean prefixed;
    private final String prefix;
    private final String name;

    public NameOperand(String prefix, String name) {
        this.prefixed = (prefix != null);
        this.prefix = prefix;
        this.name = name;
    }

    public boolean isPrefixed() {
        return prefixed;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getName() {
        return name;
    }
}
