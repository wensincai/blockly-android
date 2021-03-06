/*
 *  Copyright 2016 Google Inc. All Rights Reserved.
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.google.blockly.model;

import android.test.AndroidTestCase;

/**
 * Tests for {@link FieldVariable}.
 */
public class FieldVariableTest extends AndroidTestCase {
    public static final String FIELD_NAME = "fname";
    public static final String VARIABLE_NAME = "var";

    FieldVariable mField = new FieldVariable(FIELD_NAME, VARIABLE_NAME);

    public void setUp() {
        mField = new FieldVariable(FIELD_NAME, VARIABLE_NAME);
    }

    public void testConstructor() {
        assertEquals(Field.TYPE_VARIABLE, mField.getType());
        assertEquals(FIELD_NAME, mField.getName());
        assertEquals(VARIABLE_NAME, mField.getVariable());
    }

    public void testSetVariable() {
        mField.setVariable("newVar");
        assertEquals("newVar", mField.getVariable());
    }

    public void testSetFromString() {
        assertTrue(mField.setFromString("newestVar"));
        assertEquals("newestVar", mField.getVariable());
        assertFalse(mField.setFromString(""));
        assertEquals("newestVar", mField.getVariable());
    }

    public void testClone() {
        FieldVariable clone = mField.clone();
        assertNotSame(mField, clone);
        assertEquals(mField.getName(), clone.getName());
        assertEquals(mField.getVariable(), clone.getVariable());
    }

    public void testObserverEvents() {
        FieldTestHelper.testObserverEvent(mField,
                /* New value */ "zip",
                /* Expected old value */ VARIABLE_NAME,
                /* Expected new value */ "zip");
    }
}
