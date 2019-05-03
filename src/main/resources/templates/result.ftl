<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Weather Website</title>
        <link href="/css/main.css" rel="stylesheet">
    </head>
    <body>
		<#if currentWeather?has_content>
        <h2>Current weather from ${currentWeather.name}</h2>

		Today's date; ${currentWeather.currentDt}<br>
		City name: ${currentWeather.name}<br>
		Overall description of the weather: ${currentWeather.descriptionWeathers}<br>
		Temperature in Fahrenheit: ${currentWeather.main.tempInFahrenheit}<br>
		Temperature in Celsius: ${currentWeather.main.tempInCelsius}<br>
		Sunrise time: ${currentWeather.sunrise12hFormat}<br>
		Sunset time: ${currentWeather.sunset12hFormat}<br>
		</#if>
        <script src="/js/main.js"></script>
    </body>
</html>