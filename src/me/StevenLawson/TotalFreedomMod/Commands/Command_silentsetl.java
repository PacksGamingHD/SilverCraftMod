package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.Bridge.TFM_WorldEditBridge;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.ONLY_CONSOLE)
@CommandParameters(description = "Silently modifies every online users WorldEdit block modification limit to 1000.", usage = "/<command>")
public class Command_silentsetl extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        TFM_WorldEditBridge web = TFM_WorldEditBridge.getInstance();
        for (final Player player : server.getOnlinePlayers())
        {
            web.setLimit(player, 1000);
        }
        return true;
    }
}