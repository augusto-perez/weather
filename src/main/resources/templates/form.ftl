<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Weather Website</title>
        <link href="/css/main.css" rel="stylesheet">
    </head>
    <body>
        <h2>Enter a city to retrieve the current weather data</h2>
        <form action="/postform" method="post">
            City name:<br>
            <input type="text" name="name">
            <br><br>
            <input type="submit" value="Submit">
        </form>
        <script src="/js/main.js"></script>
    </body>
</html>