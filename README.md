## ✔️ Project Description

Technical test conducted for Pitcheers company.

## 🔨How to get started using Eclipse IDE

### Necessary software:

* JDK
* Apache Maven
* Eclipse IDE

### Running the project:

1. Download the project by clicking the green 'Code' button located on the top right corner of the code structure on this page. You can either clone it using git console, or download it as a .zip file.
2. Open the project on Eclipse IDE. To do so, click in 'File' on top left corner, then select 'Open Projects from the File System' and choose the downloaded project.
3. Wait for the dependencies to download. In the bottom left corner, you'll see a message 'Building' and a percentage, indicating the progress of the dependency download (see image below).

![image](https://github.com/EzeBalcaldi/klimberAutomation/assets/42391879/85d4c216-025c-4e2a-984a-b4d47d1cff93)


## Project Structure

The project is based on the 'Page Object Model' design pattern, where a class is created for each web page, containing its elements and locators, along with a Base class abstracting driver functionalities, and a class for each test to be executed, that are written in natural language.
In the image below, you can see the project structure:

![image](https://github.com/EzeBalcaldi/klimberAutomation/assets/42391879/1e1aa6b7-197c-4296-9193-713b5e8d3c92)

* In Pages package, you'll find classes for each of the pages, including their locators and functionalities.
* In POM package, you'll find the Base class, where all WebDriver functionalities used by the pages are abstracted.
* In Test package, all the tests to be run are located, with each class representing a test.
* In Suite package, you'll find the TestSuite class, which is a class that groups all the tests and executes them sequentially, one after another.

## 🔨Technologies Utilized

* Java
* Selenium
* JUnit


