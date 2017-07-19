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
                    <form action="addFilm" method="post">
                        <table class="table table-striped">
                            <thead>
        <tr><th>Name producer:</th>
            <th>Surname producer:</th>
            <th>Patronymic producer:</th>
            <th>Name of film: </th>
            <th>Genre:</th>
        </tr>
                            </thead>
                            <tbody>
        <tr>
            <th><input type="text" size="13" name="name_producer"></th>
            <th><input type="text" size="13" name="surname_producer"></th>
            <th><input type="text" size="13" name="patronymic_producer"></th>
            <th><input type="text" size="13" name="film"></th>
            <th><input type="text" size="13" name="genre"></th>
        </tr>
                            </tbody>
    </table>

    <input type="submit" value="добавить"/>
                    </form>
                    <form action="hello" method="post">
                        <input type="submit" value="Открыть список фильмов">
</form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>