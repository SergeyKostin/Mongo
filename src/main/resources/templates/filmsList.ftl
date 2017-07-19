<html>
<head>
    <title>Films</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="container" style="margin-top: 30px">
    <div class="row">
        <div class="col-nd-12">
            <div class="panel panel-default">
                <div class="panel-heading">КиноБиблиотека</div>
                <div class="panel-body">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>Поиск фильма по продюсеру:</th>
                            <th>Поиск фильма по названию:</th>
                            <th>Поиск фильма по жанру:</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>
                                <form action="getFilmByProd" method="post">
                                    <p>Введите фамилию продюсера:</p><input type="text" name="prod_surname">
                                    <input type="submit" value="поиск">
                                </form>
                            </td>
                            <td>
                                <form action="getFilmByName" method="post">
                                    <p>Введите название фильма:</p><input type="text" name="film_name">
                                    <input type="submit" value="поиск">
                                </form>
                            </td>
                            <td>
                                <form action="getFilmByGenre" method="post">
                                    <p>Введите жанр:</p><input type="text" name="genre">
                                    <input type="submit" value="поиск">
                                </form>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <form action="getAddFilm" method="post">
                        <input type="submit" value="Добавить фильм">
                    </form>
                    <table class="table table-striped">
                        <thead>
    <tr>
        <th>Name producer:</th>
        <th>Surname producer:</th>
        <th>Patronymic producer:</th>
        <th>Film:</th>
        <th>Genre:</th>
        <th></th>
    </tr>
                        </thead>
                    <tbody>
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
            <td>
                <form action="delete" method="post">
                    <input type="hidden" value="${prod.surname}" name="surn">
                    <input type="submit" value="delete">
                </form>
            </td>
        </tr>
    </tbody>
    </#list>
</table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>