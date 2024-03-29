# Escapable-Foreach

<p>
<a herf="https://opensource.org/licenses/Apache-2.0"><img src="https://img.shields.io/badge/LICENSE-Apache%202.0-blue"/></a>
</p>


`Escapable-Foreach` is a kotlin extension that facilitates  iterative action on iterable objects.

```kotlin
        Array<out T>.escapableForEach { index:Int, value:T? -> TODO() }
        
        List<T>.escapableForEach { index:Int, value:T? -> TODO() }
        
        Set<T>.escapableForEach { index:Int, value:T? -> TODO() }
        
        Map<T, S>.escapableForEach { index:Int, key:T, value:T? -> TODO() }
        
        JSONArray.escapableForEach<T> { index:Int, value:T? -> TODO() }
        
```

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
  implementation 'com.github.PaleCosmos:Escapable-Foreach:v1.2'
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
        if (hashMap != null) {
            var index = 0
            for (pair in hashMap) {
                Log.d("LOG", "index : $index")
                if (pair.key == "kotlin") {
                    index++
                    continue
                }
                if (!function(pair.key, pair.value)) {
                    break
                }
                index++
            }
        }
```
***Same as***
```kotlin
        hashMap.escapableForEach { index, key, value ->
            Log.d("LOG", "index : $index")
            if (key == "kotlin") return@escapableForEach CONTINUE
            return@escapableForEach function(key, value)
        }
```

### Escapable-Foreach (Nullable Type Check)
```kotlin
        if (hashMap != null) {
            var index = 0
            for (pair in hashMap) {
                if (pair.value != null) {
                    Log.d("LOG", "index : $index, ${pair.value}")
                    if (pair.key == "kotlin") {
                        index++
                        continue
                    }
                    if (!function(pair.key, pair.value)) {
                        break
                    }

                } else {
                    Log.d("LOG", "index : $index, isNull")
                    if (!function(pair.key)) {
                        break
                    }
                }
                index++
            }
        }
```
***Same as***
```kotlin
        hashMap.escapableForEachNullable(NotNull = { index, key, value ->
            Log.d("LOG", "index : $index, $value")
            if (key == "kotlin") return@escapableForEachNullable CONTINUE
            return@escapableForEachNullable function(key, value)
        },
            IsNull = { index, key ->
                Log.d("LOG", "index : $index, isNull")
                return@escapableForEachNullable function(key)
            })
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
