package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH, blockHostConsole = true)
@CommandParameters(description = "Close server to superadmins.", usage = "/<command> [on | off]")
public class Command_seniormode extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length != 1)
        {
            return false;
        }

        if (args[0].equalsIgnoreCase("off"))
        {
            TFM_ConfigEntry.SENIOR_ONLY_MODE.setBoolean(false);
            TFM_Util.adminAction(sender.getName(), "Opening the server to all players.", true);
            return true;
        }
        else if (args[0].equalsIgnoreCase("on"))
        {
            TFM_ConfigEntry.SENIOR_ONLY_MODE.setBoolean(true);
            TFM_Util.adminAction(sender.getName(), "Closing the server to non-superadmins.", true);
            for (Player player : server.getOnlinePlayers())
            {
                if (!TFM_AdminList.isSeniorAdmin(player))
                {
                    player.kickPlayer("Server is now closed to superadmins.");
                }
            }
            return true;
        }

        return false;
    }
}
