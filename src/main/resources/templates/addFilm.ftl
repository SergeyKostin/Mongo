<html>
<head></head>
<body>
<form action="addFilm" method="post">
    <table>
        <tr><th>Name producer:</th>
            <th>Surname producer:</th>
            <th>Patronymic producer:</th>
            <th>Name of film: </th>
            <th>Genre:</th>
        </tr>
        <tr>
            <th><input type="text" name="name_producer"></th>
            <th><input type="text" name="surname_producer"></th>
            <th><input type="text" name="patronymic_producer"></th>
            <th><input type="text" name="film"></th>
            <th><input type="text" name="genre"></th>
        </tr>
    </table>
    <input type="submit" value="добавить"/>
</form>
<form action="hello" method="post">
    <input type="submit" value="Open films list">
</form>
</body>
</html>