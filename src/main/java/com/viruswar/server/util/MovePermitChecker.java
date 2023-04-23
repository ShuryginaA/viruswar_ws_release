package com.viruswar.server.util;

import static com.viruswar.server.Server.CROSS_VIRUS;

public class MovePermitChecker {
    public static boolean isMovePermitForCross = true;
    public static boolean isMovePermitForRounds = true;
    
    public MovePermitChecker() {}

    public static boolean isMovePermit(String groupName){
        return groupName.equals(CROSS_VIRUS) ? isMovePermitForCross : isMovePermitForRounds;
    }
}
