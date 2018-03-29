package net.itspartner.test.n6;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Task: Process file resources/n6/source in a special way and write result to the new file.
 * Source file contains data in following format:
 * username,password,email
 *
 * You need to:
 * 1) remove duplicates by username
 * 2) make email lowercase
 * 3) remove records where password doesn't meet following conditions:
 * 3.1) password length must be at least 8 symbols
 * 3.2) password must contain at least one special character (#, @, -)
 * 3.3) password must contain exactly one uppercase character
 *
 * All the rest records should be saved in new file in the same format.
 */
public class Main {

    private static final String SOURCE_FILE_PATH = "src/main/resources/n6/source";
    private static final String RESULT_FILE_PATH = "src/main/resources/n6/result";
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("(?=.{8,})(?=.[@#\\-]*)(?=^[^A-Z]*[A-Z][^A-Z]*$)(?=.[a-z0-9]*)");

    public static List<String> findSuitableUsers(List<String> usersList) {
        List<String> suitableUsersList = new ArrayList<>();
        String prevSuitableUser = "";
        String[] userInfo;
        Collections.sort(usersList);

        for (String user: usersList) {
            userInfo = user.split(",");

            if (!userInfo[0].equals(prevSuitableUser)) {
                Matcher matcher = PASSWORD_PATTERN.matcher(userInfo[1]);

                if (matcher.find()) {
                    suitableUsersList.add(userInfo[0] + "," + userInfo[1] + "," + userInfo[2].toLowerCase());
                    prevSuitableUser = userInfo[0];
                }
            }
        }

        return suitableUsersList;
    }

    public static void main(String[] args) throws Exception {
        List<String> usersList = new ArrayList<>(Files.readAllLines(Paths.get(SOURCE_FILE_PATH)));

        if (!usersList.isEmpty()) {
            usersList = Main.findSuitableUsers(usersList);

            if (!usersList.isEmpty()) {
                Files.write(Paths.get(RESULT_FILE_PATH), usersList, Charset.forName("UTF-8"));
            } else {
                System.out.println("No suitable users");
            }
        } else {
            System.out.println("File is empty");
        }
    }
}
