package me.StevenLawson.TotalFreedomMod.Commands;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(description = "Shows users the voting links", usage = "/<command>", aliases = "voting")
public class Command_vote extends TFM_Command
{
@Override
public boolean run(final CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
{
    TFM_Util.bcastMsg("****" + ChatColor.GOLD + "Voting Links" + ChatColor.DARK_GREEN + "****", ChatColor.DARK_GREEN);
    TFM_Util.bcastMsg("http://minecraft-mp.com/server-s56156", ChatColor.AQUA);
    TFM_Util.bcastMsg("****" + ChatColor.GOLD + "Voting Links" + ChatColor.DARK_GREEN + "****", ChatColor.DARK_GREEN);
return true;
}
}
