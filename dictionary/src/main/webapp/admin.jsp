<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Page</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<jsp:include page="site-elements/header.jsp"/>
<h1>Welcome Admin!</h1>

<h2>Add Language</h2>
<form method="post" action="addLanguageServlet">
    <label for="language">Language:</label>
    <input type="text" name="language" id="language"><br><br>
    <input type="submit" value="Add Language">
</form>

<h2>Edit Language</h2>
<form method="post" action="editLanguageServlet">
    <label for="languageId">Language ID:</label>
    <input type="text" name="languageId" id="languageId"><br><br>
    <label for="language">Language:</label>
    <input type="text" name="language" id="language"><br><br>
    <input type="submit" value="Edit Language">
</form>

<h2>Delete Language</h2>
<form method="post" action="deleteLanguageServlet">
    <label for="languageId">Language ID:</label>
    <input type="text" name="languageId" id="languageId"><br><br>
    <input type="submit" value="Delete Language">
</form>

<!-- Аналогічні форми для слов та перекладів -->
<h2>Add Word</h2>
<form method="post" action="addWordServlet">
    <label for="word">Word:</label>
    <input type="text" name="word" id="word"><br><br>
    <label for="languageId">Language ID:</label>
    <input type="text" name="languageId" id="languageId"><br><br>
    <input type="submit" value="Add Word">
</form>

<h2>Edit Word</h2>
<form method="post" action="editWordServlet">
    <label for="wordId">Word ID:</label>
    <input type="text" name="wordId" id="wordId"><br><br>
    <label for="word">Word:</label>
    <input type="text" name="word" id="word"><br><br>
    <label for="languageId">Language ID:</label>
    <input type="text" name="languageId" id="languageId"><br><br>
    <input type="submit" value="Edit Word">
</form>

<h2>Delete Word</h2>
<form method="post" action="deleteWordServlet">
    <label for="wordId">Word ID:</label>
    <input type="text" name="wordId" id="wordId"><br><br>
    <input type="submit" value="Delete Word">
</form>

<h2>Add Translation</h2>
<form method="post" action="addTranslationServlet">
    <label for="wordId">Word ID:</label>
    <input type="text" name="wordId" id="wordId"><br><br>
    <label for="translation">Translation:</label>
    <input type="text" name="translation" id="translation"><br><br>
    <input type="submit" value="Add Translation">
</form>

<h2>Edit Translation</h2>
<form method="post" action="editTranslationServlet">
    <label for="translationId">Translation ID:</label>
    <input type="text" name="translationId" id="translationId"><br><br>
    <label for="translation">Translation:</label>
    <input type="text" name="translation" id="translation"><br><br>
    <input type="submit" value="Edit Translation">
</form>

<h2>Delete Translation</h2>
<form method="post" action="deleteTranslationServlet">
    <label for="translationId">Translation ID:</label>
    <input type="text" name="translationId" id="translationId"><br><br>
    <input type="submit" value="Delete Translation">
</form>


<jsp:include page="site-elements/footer.jsp"/>
</body>
</html>
