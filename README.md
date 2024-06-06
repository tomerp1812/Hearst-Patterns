# Hypernym-Relations Project

## Preview
Hypernymy (IS-A relation) is a semantic relationship between two noun phrases where the hyponym (subtype) is included under the scope of the hypernym. For example, "dog" and "cat" are hyponyms of "animal" because they are types of animals. This project focuses on building and querying a database of such hypernym relations.

## Project Description
This project comprises two main components:

1. **Creating a Hypernym-Relations Database:**
   - The program reads all files in a specified directory path, identifies hypernym relations using Hearst patterns through regular expressions, and saves these relations to a text file in a designated output path.

2. **Discovering Hypernyms:**
   - For a given lemma, the program searches and displays all possible hypernyms along with their occurrence frequencies, outputting this information to the console.

## Key Features
- **Hypernym Extraction**: Utilizes regular expressions to detect and extract hypernym relations from text based on predefined Hearst patterns.
- **Data Management**: Employs a `TreeMap` where strings (lemmas) are keys and `HyperNym` class instances are values, ensuring efficient data retrieval and storage.
- **Sorting and Ordering**: Implements Java Streams to sort lists of hypernyms within the `HyperNym` class, ensuring data is presented in a sorted manner using the `compareTo` method.

## Technologies Used
- **Java**: Main programming language.
- **Regular Expressions**: For pattern matching and text manipulation.
- **Java Collections Framework**: Specifically, `TreeMap` for structured data management and `Stream API` for processing collections.
