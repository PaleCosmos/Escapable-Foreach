# Escapable-Foreach

<p>
<a herf="https://opensource.org/licenses/Apache-2.0"><img src="https://img.shields.io/badge/LICENSE-Apache%202.0-blue"/></a>
</p>


`Escapable-Foreach` is a kotlin extension that facilitates  iterative action on iterable objects.

```kotlin
        array.escapableForEach { index, value ->
            if(index>3)return@escapableForEach BREAK
            function(index, value)
            return@escapableForEach CONTINUE
        }
        arrayList.escapableForEach { index, value ->
            if(index>3)return@escapableForEach BREAK
            function(index, value)
            return@escapableForEach CONTINUE
        }
        list.escapableForEach { index, value ->
            if(index>3)return@escapableForEach BREAK
            function(index, value)
            return@escapableForEach CONTINUE
        }
        jsonArray.escapableForEach<String> { index, value ->
            if(index>3)return@escapableForEach BREAK
            function(index, value)
            return@escapableForEach CONTINUE
        }
```


## Implementation


[![Jitpack](https://jitpack.io/v/PaleCosmos/Escapable-Foreach.svg)](https://jitpack.io/#PaleCosmos/Escapable-Foreach)

### Gradle
Add a dependency code to your module's `build.gradle`.
```gradle
dependencies {
  implementation 'com.github.PaleCosmos:Escapable-Foreach:v1.1'
}
```
***or***
```gradle
dependencies {
  implementation 'com.github.PaleCosmos:Escapable-Foreach:version'
}
```

## Usage
### Escapable-Foreach
```kotlin
TODO()
```

### Dictionary
```kotlin
  val dictionary = Dictionary(arrayOf(0, 1, 2, 3, 4, 5)) { i ->
            "$i"
        }

        dictionary.escapableForeach { index, key, value ->
            if (index < 1 || key == 3) return@escapableForeach CONTINUE
            
            if (value == null) return@escapableForeach BREAK

            CONTINUE
        }
```

# License
```xml
Copyright 2019 PaleCosmos

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
