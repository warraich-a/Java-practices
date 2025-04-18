# 📘 Java Stream API – Hands-on Notes

These are personal learning notes and examples based on practicing with the Java Stream API using custom `Fruit` objects.  
Each section covers a key concept with syntax, explanation, and links to actual Java files in the `/Streams` folder.

---

## 📂 Basics

### What is a Stream?

A stream is a pipeline to process a collection of data (like a List) in a functional style.

**Structure:**

```
list.stream() → intermediate steps (filter, map, etc.) → terminal step (collect, toList, count, etc.)
```

---

## 🔍 filter()

### Purpose:

Keep only the items that match a condition.

```java
fruits.stream()
    .filter(fruit -> fruit.color.equals("Red"))
    .toList();
```

**Result:** All red fruits.

📄 See: `FruitStreamPractice_1.java`, Challenge 1

---

## 🔁 map()

### Purpose:

Transform each item in the stream into something else.

```java
fruits.stream()
    .map(fruit -> fruit.name)
    .toList();
```

**Result:** A list of fruit names (List<String>)

📄 See: `FruitStreamPractice_1.java`, Challenge 2

---

## 🧼 distinct()

### Purpose:

Remove duplicate values (based on `equals()` + `hashCode()`).

```java
fruits.stream()
    .distinct()
    .toList();
```

For custom objects, make sure to override both `equals()` and `hashCode()`.

📄 See: `StreamDistinctDemo.java`, `Fruit.java`

---

## 🔢 sorted()

### Purpose:

Sort the list using natural or custom order.

#### Example A: Natural order (String)

```java
names.stream().sorted().toList();
```

#### Example B: Custom order (by color)

```java
fruits.stream()
    .sorted(Comparator.comparing(fruit -> fruit.color))
    .toList();
```

#### Example C: Custom reverse order

```java
.sorted(Comparator.comparing(fruit -> fruit.color).reversed())
```

#### Example D: Multiple fields

```java
.sorted(
  Comparator.comparing((Fruit f) -> f.name)
            .thenComparing(f -> f.color)
)
```

📄 See: `StreamSortedDemo.java`, `FruitStreamPractice_1.java`

---

## 📊 groupingBy()

### Purpose:

Group items by a field and return a `Map<Key, List<Values>>`

```java
Map<String, List<Fruit>> grouped = fruits.stream()
    .collect(Collectors.groupingBy(fruit -> fruit.color));
```

### Count items per group:

```java
Map<String, Long> count = fruits.stream()
    .collect(Collectors.groupingBy(f -> f.color, Collectors.counting()));
```

📄 See: `GroupingDemo.java`, `FruitStreamPractice_1.java`

---

## ✅ Summary: When to Use What

| You want to...                       | Use this method          |
| ------------------------------------ | ------------------------ |
| Keep only certain items              | `filter()`               |
| Transform data (e.g., object → name) | `map()`                  |
| Remove duplicates                    | `distinct()`             |
| Sort alphabetically or custom        | `sorted()`               |
| Group into categories                | `groupingBy()`           |
| Count grouped items                  | `Collectors.counting()`  |
| Flatten nested lists                 | `flatMap()` (next level) |

---

## 📂 Source Folder Structure

```
Streams/
├── StreamMapDemo.java
├── StreamFilterDemo.java
├── StreamSortedDemo.java
├── StreamDistinctDemo.java
├── GroupingDemo.java
├── FruitStreamPractice_1.java
└── StreamNotes.md ← (this file)
```

---

## 💬 Tips

- Don’t memorize — recognize patterns.
- Practice > reading
- Print this file or keep it open while coding

---
