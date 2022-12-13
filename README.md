# Jetpack Compose Codelabs for ComposeCampTH2022

This repository contains a set of Android Studio projects to help you learn about
Compose in Android. Each sample contains the code for a specific Compose codelab.

For more information about Jetpack Compose, please [read the documentation](https://developer.android.com/jetpack/compose)

## 💻 Requirements

[Android Studio Dolphin](https://developer.android.com/studio).

Android Device or Emulator API >= 29

## 🧬 Codelabs

### [Basics codelabs](https://developer.android.com/codelabs/jetpack-compose-basics)

Go hands-on and learn the fundamentals of declarative UI, working with state, layouts and theming.

### [Basic layouts codelab](https://developer.android.com/codelabs/jetpack-compose-layouts)

Learn how to implement real-world designs with the composables and modifiers that Compose provides out of the box.

### [State codelab](https://developer.android.com/codelabs/jetpack-compose-state)

Understand patterns for working with state in a declarative world by building a Wellness application.

### [Migration codelab](https://developer.android.com/codelabs/jetpack-compose-migration)

Understand how Jetpack Compose and View-based UIs can co-exist and interact, making it easy to
adopt Compose at your own pace.

### [Animation codelab](https://developer.android.com/codelabs/jetpack-compose-animation)

Learn how to use Jetpack Compose Animation APIs.

### [Navigation codelab](https://developer.android.com/codelabs/jetpack-compose-navigation)

Learn how to use the Jetpack Navigation library in Compose, navigate within your application,
navigate with arguments, support deep-links, and test your navigation.

### [Testing codelab](https://developer.android.com/codelabs/jetpack-compose-testing)

Learn about testing Jetpack Compose UIs. Write your first tests, and learn about testing in
isolation, debugging tests, the semantics tree, and test synchronization.

## License

```
Copyright 2021 The Android Open Source Project

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

### My Lecture

```

Codelab Note

สาเหตุที่ compose ไม่มี margin เพราะเขาอยากให้คนใช้ Spacer แทน

การ alignment
- Column จะ align horizontal
- Row จะ alignVertical

การส่ง modifier มาจากข้างนอก จะใช้เฉพาะกับ rootview

** modifier ต้องใส่ที่ root composable เท่านั้น

Remember ต้องประกาศใน composable area เท่านั้น สามารถใส่ key ได้ ใช้เมื่อต้องการเปรียบเทียบกับ key เดิม

ใน viewmodel เลยไม่สามารถใช้ remember ได้

mutableStateFlow ดีกว่า mutableState ธรรมดายังไง ->
	mutableState เป็น android

Stateless = ไม่มีอะไรข้างในที่เก็บ state
ประโยชน์คือมัน render state ได้ครบ

ที่ต้องหาเพิ่ม state hoisting pattern

ตัวอย่างของ stateless ที่เป็น official คือ TextEditor

อย่าไปถือ android specific ใน view model

Steam based type to state
StateFlow ใช้กับ kotlin cross platform ได้


Migration
- เวลา data update แล้วมีการ update layout จะเกิดอะไรขึ้นบ้าง
- Layout ทำงานอะไรบ้าง
    - วัด -> ต้องรู้ขนาดของ child ตำแหน่งอยู่ตรงไหนบ้าง
    - Render ui
- Lazy layout
    - คล้ายกับ Recyclerview
    - Column, Row, Grid
    - ข้อดีคือเขียน code แล้วสั้นลงเยอะ
    - ถ้าอยากทำ header ให้ใช้ item
    - ถ้าอยากทำ list ให้ใช้ items
    - ถ้าอยากใช้ index ให้ใช้ itemIndexed
    - ถ้าอยากเพิ่ม space ระหว่าง item ให้ใช้ verticalAlignment = Arrangement.spaceBy(ขนาด.dp)
- Lazy Grid
    - Fix Row
    - เพิ่ม element ได้ทั้ง 2 แกน
    - ถ้ามีการ rotate แล้วอยากให้คำนวณจอใหม่ให้ใช้ column = GridCell.Adaptive(ขนาดจอ)
    - ทำ item ขนาดไม่เท่ากันได้
    - ระวังเรื่อง index
- สิ่งที่ต้องระวังในการใช้งาน lazy column คือ อย่าใช้ 0 pixel แล้วก็ต้องใช้ placeholder ด้วย
- หลีกเลี่ยงการใช้ scroll ทิศทางเดียวกันในหน้าเดียวกัน
- ถ้าเดิม nestedScrollview สามารถใช้ lazycoloumn ร่วมกับ key และ view type ได้ ช่วยให้ใช้งาน notifyItemChanged ได้
- ถ้าใส่ทั้ง 2 อย่างแล้วยังกระตุก ให้ไป debug ดูว่า tree item เป็นอย่างไร composable มันมีการวัดขนาดและการคำนวณเยอะเกินไปหรือไม่


Animation
- Shimmer กับ viewpager จะอยู่ใน https://google.github.io/accompanist/ ตัวนี้
- ตอนทำ ui test ต้องปิด animation
- การทำ animation จะทำให้เกิด recomposable สูงมาก ถ้าไม่จำเป็น ไม่ใช้ก็ดีเหมือนกัน

Advanced State and side Effect
- State holder
- note ห้ามเรียก function ข้างนอกตอน recompose ต้องไปแก้ใน effect
- Scaffold state มี mechanic พิเศษคือ support drawer กับ scalf bar โดยที่เราไม่ต้องสร้างเอง
- Event ที่เกิดจาก user ต้องเปิด scope แยก แต่ event ที่เกิดจาก recompose ต้องใช้ effect ที่ทำหน้าที่เหมือน oncreate
- สิ่งที่เจอ
    - LaunchedEffect ใส่ไปเมื่อต้องการ coroutineScope ข้างใน
    - Snackbar ต้องการ coroutineScope
    - LaunchedEffect ใช้เช็ค login
    - remembercoroutineScope
    - rememberUpdateState
    - DisposableEffect -> effect ที่ต้องการการ clean up
    - produceState
    - snapshortFlow -> แปลง state compose ให้กลายเป็น flow แล้ว observe ได้


Navigation Codelab
- ต้อง migrate ทุกอย่างเป็น compose ถึงจะใช้งานได้
- ถ้าจะใช้ต้องมี navigation controller, navhost

Test
- มี cheat sheet
- Action คือต้องการ action อะไรจาก user
- Compose เป็น node driven
- Finder ต้องใช้ matcher
- ในการ test ui เราจะไม่ค่อยสนใจ theme สักเท่าไร
- เริ่มแรกเราจะเริ่มจากประกาศ testrule
- useUnMergeTree คือการปลดล็อค tree ทั้งหมดที่ถูกซ่อนอยู่
- การบ้านคือ performClick แล้ว findNode แต่ละ tab แล้ว ดูว่ามัน recompose ไหม
- ถ้าจะใช้ context test ต้อง set ที่ @Rule val context = createAndroidComposeRule<RallyActivity>()

Performance Gotchas
- อันดับแรกต้องใช้ release mode with R8 enabled
- การคำนวณที่ซับซ้อนควรอยู่ใน viewmodel
- Remember ช่วยจำค่าได้ดี
- Sort ควรอยู่ใน view model
- การแก้ state หรือการ call lambda ห้ามทำที่ composable area
- ใช้ Modifier.drawBehind เพื่อลดการ recompose ใช้ redraw แทน
- ดู Baseline Profile


```