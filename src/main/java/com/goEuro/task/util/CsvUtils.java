/**
 *
 */
package com.goEuro.task.util;

import java.io.FileWriter;
import java.io.IOException;

import com.goEuro.task.bo.Location;
import com.goEuro.task.exception.GoEuroBaseException;
import com.goEuro.task.exception.GoEuroErros;

/**
 * The Class CsvUtils.
 *
 * @author mustafa.kamel
 */
public class CsvUtils {

    private static final String DELIMITER = ", ";

    private static final String NEW_LINE = "\n";

    private static final String HEADER = "_id, name, type, latitude, longitude";

    /**
     * Write to CSV file.
     *
     * @param locations the locations
     * @throws GoEuroBaseException if failed to create or write the CSV file
     */
    public static void writeToCsvFile(final String fileName, final Location[] locations) throws GoEuroBaseException {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.append(HEADER.toString());
            fileWriter.append(NEW_LINE);

            for (final Location city : locations) {
                fileWriter.append(city.getId());
                fileWriter.append(DELIMITER);
                fileWriter.append(city.getName());
                fileWriter.append(DELIMITER);
                fileWriter.append(city.getType());
                fileWriter.append(DELIMITER);
                fileWriter.append(city.getGeoPosition().getLatitude());
                fileWriter.append(DELIMITER);
                fileWriter.append(city.getGeoPosition().getLongitude());
                fileWriter.append(NEW_LINE);
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (final IOException ex) {
            throw GoEuroErros.FILE_CREATION_WRITING_EXCEPTION.buildException(ex);
        }

        System.out.println("file created successfully.");
    }
}
