# GoEuro-DevTest
#####*The Go Euro developers test solution project.*

GoEuro-DevTest-0.0.1-SNAPSHOT.jar is available under [Github Releases of this repo](https://github.com/mustafadagher/GoEuro-DevTest/releases). You can download it [from here.](https://github.com/mustafadagher/GoEuro-DevTest/releases/download/v0.0.1/GoEuro-DevTest-0.0.1-SNAPSHOT.jar)

It's a Java command line tool that takes an input parameter as a string:

java -jar GoEuro-DevTest-0.0.1-SNAPSHOT.jar "CITY_NAME"

For Example:

java -jar GoEuro-DevTest-0.0.1-SNAPSHOT.jar Berlin

The program takes this string and queries with it our Location JSON API: The app should use this API endpoint:

http://api.goeuro.com/api/v2/position/suggest/en/CITY_NAME

Where CITY_NAME is the string that the user has entered as a parameter when calling the tool, e.g.

http://api.goeuro.com/api/v2/position/suggest/en/Berlin

The endpoint always responds with a JSON array that contains JSON objects as elements. Each object, among other keys, has a name and a geo_position key. The geo_position key is an object with latitude and longitude fields. If no matches are found an empty JSON array is returned.

The program should query the API with the user input and create a CSV file from it. The CSV file should have the form: _id, name, type, latitude, longitude