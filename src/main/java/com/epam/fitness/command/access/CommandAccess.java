package com.epam.fitness.command.access;

import com.epam.fitness.command.factory.CommandType;
import com.epam.fitness.model.UserRole;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Designed to provide access to different users
 */
public class CommandAccess {

    /**
     * Gets available command types by user.
     *
     * @param role User role
     * @return List of available commands for certain user
     * @throws IllegalArgumentException when User role is unsupported
     */
    public List<CommandType> getAvailableCommandTypesByUser(Optional<String> role) {
        List<CommandType> listAvailableCommands = new ArrayList<>();
        if(role.isPresent()) {
            listAvailableCommands.addAll(getCommonCommands());
            switch (role.get()) {
                case UserRole.CLIENT: {
                    listAvailableCommands.addAll(getClientCommands());
                    break;
                }
                case UserRole.COACH: {
                    listAvailableCommands.addAll(getCoachCommands());
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unsupported role");
                }
            }
        }else{
            listAvailableCommands.addAll(getCommandsForNotAuthorized());
        }
        return listAvailableCommands;
    }

    private List<CommandType> getClientCommands() {
        List<CommandType> commandTypes = new ArrayList<>();
        commandTypes.add(CommandType.ADD_COMMENT);
        commandTypes.add(CommandType.ADD_EXERCISE);
        commandTypes.add(CommandType.CHOOSE_COACH);
        commandTypes.add(CommandType.CLIENT_REGISTRATION);
        commandTypes.add(CommandType.COACHES);
        commandTypes.add(CommandType.DELETE_EXERCISE);
        commandTypes.add(CommandType.GET_ORDER_PAGE);
        commandTypes.add(CommandType.PROFILE);
        commandTypes.add(CommandType.REJECT_COACH);
        commandTypes.add(CommandType.SHOW_CLIENT_EXERCISES);
        commandTypes.add(CommandType.SHOW_CLIENT_NUTRITION);
        commandTypes.add(CommandType.UPDATE_EXERCISE);
        commandTypes.add(CommandType.UPDATE_GYM_MEMBERSHIP);
        commandTypes.add(CommandType.UPDATE_NUTRITION);
        commandTypes.add(CommandType.ORDERS);
        commandTypes.add(CommandType.NO_ACCESS);
        return commandTypes;
    }

    private List<CommandType> getCommonCommands() {
        List<CommandType> commandTypes = new ArrayList<>();
        commandTypes.add(CommandType.LANGUAGE);
        commandTypes.add(CommandType.GYM_PHOTOS);
        commandTypes.add(CommandType.LOGIN);
        commandTypes.add(CommandType.MAIN);
        commandTypes.add(CommandType.SIGN_OUT);
        commandTypes.add(CommandType.LOGIN_PAGE);
        return commandTypes;
    }

    private List<CommandType> getCoachCommands() {
        List<CommandType> commandTypes = new ArrayList<>();
        commandTypes.add(CommandType.SHOW_COACH_COMMENTS);
        commandTypes.add(CommandType.ALL_COACH_CLIENTS);
        commandTypes.add(CommandType.SHOW_CLIENT_NUTRITION);
        commandTypes.add(CommandType.SHOW_CLIENT_EXERCISES);
        commandTypes.add(CommandType.UPDATE_NUTRITION);
        commandTypes.add(CommandType.ADD_EXERCISE);
        commandTypes.add(CommandType.UPDATE_EXERCISE);
        commandTypes.add(CommandType.DELETE_EXERCISE);
        return commandTypes;
    }

    private List<CommandType> getCommandsForNotAuthorized() {
        List<CommandType> commandTypes = new ArrayList<>();
        commandTypes.add(CommandType.LOGIN);
        commandTypes.add(CommandType.LANGUAGE);
        commandTypes.add(CommandType.NO_ACCESS);
        commandTypes.add(CommandType.LOGIN_PAGE);
        commandTypes.add(CommandType.CLIENT_REGISTRATION);
        commandTypes.add(CommandType.SIGN_OUT);
        return commandTypes;
    }

}
