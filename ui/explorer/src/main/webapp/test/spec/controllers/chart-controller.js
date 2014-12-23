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

'use strict';

describe('Controller: ChartControllerCtrl', function () {

    // load the controller's module
    beforeEach(module('chartingApp'));

    var ChartControllerCtrl,
        scope;

    // Initialize the controller and a mock scope
    beforeEach(inject(function ($controller, $rootScope) {
        scope = $rootScope.$new();
        ChartControllerCtrl = $controller('ChartController', {
            $scope: scope
        });
    }));

    it('should have this variable in scope', function () {
        expect(scope.vm.dateTimeRanges).toBeDefined();
    });
});
