##第七章 Java 中的13个原子操作类

### 原子更新基本类型类

- AtomicBoolean：原子更新布尔类型类
- AtomicInteger： 原子更新整型类
- AtomicLong:原子更新长整型

### 原子更新数组

- AtomicIntegerArray:原子更新整型数组里的元素。
- AtomicLongArray:原子更新长整型数组里的元素。
- AtomicReferenceArray:原子更新引用类型数组里的元素。

### 原子更新引用类型

- AtomicReference:原子更新引用类型。
- AtomicReferenceFieldUpdater:原子更新引用类型里的字段。
- AtomicMarkableReference:原子更新带有标记位的引用类型。

### 原子更新字段类

- AtomicIntegerFieldUpdater:原子更新整型的字段的更新器。
- AtomicLongFieldUpdater:原子更新长整型字段的更新器。
- AtomicStampedReference:原子更新带有版本号的引用类型。