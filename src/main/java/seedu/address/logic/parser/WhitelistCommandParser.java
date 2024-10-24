package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CLIENT_STATUS;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.WhitelistCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.ClientStatus;

/**
 * Parses input arguments and creates a new WhitelistCommand object
 */
public class WhitelistCommandParser implements Parser<WhitelistCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the EditCommand
     * and returns an EditCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public WhitelistCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_CLIENT_STATUS);

        Index index;

        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, WhitelistCommand.MESSAGE_USAGE), pe);
        }

        ClientStatus newClientStatus = ParserUtil.parseClientStatus(argMultimap.getValue(PREFIX_CLIENT_STATUS).get());

        return new WhitelistCommand(index, newClientStatus);
    }
}
