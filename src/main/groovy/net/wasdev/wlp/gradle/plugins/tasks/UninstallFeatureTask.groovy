/**
 * (C) Copyright IBM Corporation 2015.
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
package net.wasdev.wlp.gradle.plugins.tasks

import org.gradle.api.tasks.TaskAction

class UninstallFeatureTask extends AbstractTask {

    @TaskAction
    void uninstallFeature() {
        def params = buildLibertyMap(project);
        params.put('name', project.liberty.uninstallfeatures.name.join(","))
        params.remove('timeout')
        
        project.ant.taskdef(name: 'uninstallFeature', 
                            classname: 'net.wasdev.wlp.ant.UninstallFeatureTask', 
                            classpath: project.buildscript.configurations.classpath.asPath)
        project.ant.uninstallFeature(params)
    }

}
