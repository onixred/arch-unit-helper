/*
 *  Copyright 2023 Contributors to the Sports-club.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package ru.onixred.arch.unit.helper.rule;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.library.Architectures;

import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 * crested on 31.01.2025
 */
public class LayeredRuleTest implements ArchUnitRuleTest {

    /**
     * Все классы которые в пакете PackageName должны удовлетворять структуре layerBeAccessedByLayers
     *
     * @param packagePath     путь базового пакета для анализа
     * @param layerBeAccessedByLayers карта где ключ это слой, а значение список слоев которые зависят от этого слоя
     */
    public static void execute(String packagePath, Map<ParamLayer, List<ParamLayer>> layerBeAccessedByLayers) {

        JavaClasses importedClasses = new ClassFileImporter()
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
                .importPackages(packagePath);
        Architectures.LayeredArchitecture layeredArchitecture = Architectures.layeredArchitecture().consideringAllDependencies();
        for(ParamLayer layer: layerBeAccessedByLayers.keySet()) {
            layeredArchitecture = layeredArchitecture.layer(layer.getName()).definedBy(layer.getPackageName());
        }

        for(Map.Entry<ParamLayer, List<ParamLayer>> entry: layerBeAccessedByLayers.entrySet()) {
            List<ParamLayer> layers =  entry.getValue();
            if(layers == null || layers.isEmpty()) {
                layeredArchitecture = layeredArchitecture.whereLayer(entry.getKey().getName()).mayNotBeAccessedByAnyLayer();
            } else {
                String[] names = layers.stream().map(ParamLayer::getName).toList().toArray(new String[0]);
                layeredArchitecture = layeredArchitecture.whereLayer(entry.getKey().getName()).mayOnlyBeAccessedByLayers(names);
            }

        }
        layeredArchitecture.check(importedClasses);

    }
}
