# arch-unit-helper

Вспомогательная библиотека для создания единых правил\шаблонов в архитектуре кода.

### Список вспомогательных классов

1. AnnotationsForAllClassesAssignableToClassRuleTest - Все поля классов реализующие интерфейс assignableClass используют аннотации из списка annotations
2. AnnotationsForAllPublicMethodsToClassRuleTest - Все публичные методы классов из пакета resideInAPackage должны использовать аннотацию annotation
3. ComponentDependencyMetricsRuleTest - Проверка метрик связности
4. LakosMetricsRuleTest - Проверка метрик Джона Лакоса
5. LayeredRuleTest - Все классы которые в пакете PackageName должны удовлетворять структуре layerBeAccessedByLayers (Проверка взаимосвязей между слоями)
6. NamingConventionInPackageRuleTest - Все классы которые в пакете PackageName должны заканчиваются согласно правилу RuleNameEnding
7. OnlyDependOnClassesRuleTest -  Все классы из пакета resideInAPackage должны содержать заданный список зависимостей resideInAnyPackages
7.  OnlyHaveNameNotMatchingRuleTest - Все классы подходящие под regex должны могут содержать список зависимостей resideInAnyPackages
8. PackageContainmentRuleTest - Все классы которые именованы согласно правилу RuleNameEnding должны находится в пакете PackageName

### Прримеры