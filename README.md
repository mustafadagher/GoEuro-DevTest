# GoEuro-DevTest
#####*The Go Euro developers test project.*

A Java command line tool that takes as an input parameter a string

java -jar GoEuroTest.jar "CITY_NAME"

The program takes this string and queries with it our Location JSON API: The app should use this API endpoint:

http://api.goeuro.com/api/v2/position/suggest/en/CITY_NAME

Where CITY_NAME is the string that the user has entered as a parameter when calling the tool, e.g.

http://api.goeuro.com/api/v2/position/suggest/en/Berlin

The endpoint always responds with a JSON array that contains JSON objects as elements. Each object, among other keys, has a name and a geo_position key. The geo_position key is an object with latitude and longitude fields. If no matches are found an empty JSON array is returned.

The program should query the API with the user input and create a CSV file from it. The CSV file should have the form: _id, name, type, latitude, longitude