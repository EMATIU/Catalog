
### Description
This project is an innovative application that simulates an online student class catalog, providing a modern digital platform for managing and monitoring students' academic progress. With the help of Catalog, teachers, students and parents can collaborate efficiently and access relevant information about academic performance in a simple and accessible manner.

### Functionalities 
1) Add a new teacher
2) Delete a teacher
3) Add a student
4) Delete a student
5) Display all the subjects
6) Display the teacher of each subject

### Classes
- Person (sealed class)
- Parent (non-sealed class, extends Person)
- Teacher (non-sealed class, extends Person)
- Student (non-sealed class, extends Person)
- Grade
- Subject
- Semester (enum)
- SubjectName (enum)

### Service classes
1) StudentService(interface) -> StudentServiceImpl (implementation of its interface)
2) TeacherService(interface) -> TeacherServiceImpl (implementation of its interface)
3) SubjectService(interface) -> SubjectServiceImpl (implementation of its interface)

### First part 
- creating the classes
- adding service classes and their implementations
- creating a interactive menu

### Second part
- transforming the abstract class Person into a sealed class and its subclasses (Parent, Teacher, Student) into non-sealed ones

