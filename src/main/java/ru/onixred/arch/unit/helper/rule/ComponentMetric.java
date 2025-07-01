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

/**
 * Description:
 *
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 * crested on 31.01.2025
 * @param afferentCoupling Ce - показывает зависимости пакета от внешних пакетов (исходящие зависимости)
 * @param efferentCoupling Ca - показывает зависимости внешних пакетов от указанного пакета (входящие зависимости)
 * @param instability I - Ce / (Ca + Ce), т.е. отношение исходящих зависимостей ко всем зависимостям
 */
public record ComponentMetric( int efferentCoupling, int afferentCoupling, double instability) {
}
