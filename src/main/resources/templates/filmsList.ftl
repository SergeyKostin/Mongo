<html>
<head></head>
<body>
<table>
    <tr>
        <th>Name producer:</th>
        <th>Surname producer:</th>
        <th>Patronymic producer:</th>
        <th>Film:</th>
        <th>Genre:</th>
        <th></th>
    </tr>
    <#list prodList as prod>
        <tr>
            <td>${prod.name}</td>
            <td>${prod.surname}</td>
            <td>${prod.patronymic}</td>
            <td>
                <#list prod.filmList as film>
                <p>${film.name}</p>
                </td>
            <td>
                <#list film.genreList as genre>
                <p>${genre.name}</p>
            </td>
                </#list>
                </#list>
        </tr>
    </#list>
</table>


<form action="getAddFilm" method="post">
    <input type="submit" value="AddFilm">
</form>
</body>
</html>