/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.hive.ql.ddl.database.alter.location;

import org.apache.hadoop.hive.ql.ddl.database.alter.AbstractAlterDatabaseDesc;
import org.apache.hadoop.hive.ql.plan.Explain;
import org.apache.hadoop.hive.ql.plan.Explain.Level;

/**
 * DDL task description for ALTER DATABASE ... SET LOCATION ... commands.
 */
@Explain(displayName = "Set Database Location", explainLevels = { Level.USER, Level.DEFAULT, Level.EXTENDED })
public class AlterDatabaseSetLocationDesc extends AbstractAlterDatabaseDesc {
  private static final long serialVersionUID = 1L;

  private String location = null;
  private String managedLocation = null;

  public AlterDatabaseSetLocationDesc(String databaseName, String location) {
    this(databaseName, location,null);
  }

  public AlterDatabaseSetLocationDesc(String databaseName, String location, String managedLocation) {
    super(databaseName, null);
    if (location != null) {
      this.location = location;
    }

    if (managedLocation != null) {
      this.managedLocation = managedLocation;
    }
  }

  @Explain(displayName="location")
  public String getLocation() {
    return location;
  }

  @Explain(displayName="managedLocation")
  public String getManagedLocation() {
    return managedLocation;
  }
}