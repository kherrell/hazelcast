/*
 * Copyright (c) 2008-2020, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.sql.impl.expression.time;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.sql.impl.expression.CallExpression;
import com.hazelcast.sql.impl.expression.CallOperator;
import com.hazelcast.sql.impl.row.Row;
import com.hazelcast.sql.impl.type.DataType;

import java.io.IOException;
import java.time.OffsetDateTime;

/**
 * Function to get local timestamp.
 */
public class LocalTimestampFunction implements CallExpression<OffsetDateTime> {
    @Override
    public OffsetDateTime eval(Row row) {
        return OffsetDateTime.now();
    }

    @Override
    public DataType getType() {
        return DataType.TIMESTAMP_WITH_TIMEZONE_OFFSET_DATE_TIME;
    }

    @Override
    public int operator() {
        return CallOperator.CURRENT_TIMESTAMP;
    }

    @Override
    public void writeData(ObjectDataOutput out) throws IOException {
        // No-op.
    }

    @Override
    public void readData(ObjectDataInput in) throws IOException {
        // No-op.
    }
}