package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.ExportCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new ExportCommand object.
 */
public class ExportCommandParser implements Parser<ExportCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ExportCommand
     * and returns an ExportCommand object for execution.
     *
     * @param args String that user enters
     * @return ExportCommand
     * @throws ParseException If the user input does not conform to the expected format.
     */
    public ExportCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ExportCommand.MESSAGE_USAGE));
        }

        String[] fileNameKeywords = trimmedArgs.split("\\s+");

        if (fileNameKeywords.length > 1) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ExportCommand.MESSAGE_USAGE));
        }

        String fileName = fileNameKeywords[0];

        return new ExportCommand(fileName);
    }
}