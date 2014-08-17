package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Ban;
import me.StevenLawson.TotalFreedomMod.TFM_BanManager;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TFM_UuidResolver;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(description = "Manage and slams the VJHammer over a bad-player", usage = "/<command> <playername>")
public class Command_vj extends TFM_Command
{
    @Override
    public boolean run(final CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length != 1)
        {
            return false;
        }

        final Player player = getPlayer(args[0]);

        if (player == null)
        {
            sender.sendMessage(TotalFreedomMod.PLAYER_NOT_FOUND);
            return true;
        }
        player.getWorld().strikeLightning(player.getLocation());
        player.getWorld().strikeLightning(player.getLocation());
        player.getWorld().strikeLightning(player.getLocation());
        player.setFireTicks(10000);
        player.setHealth(0.0);
        TFM_Util.adminAction("vj13573", "I AM REALLY DISAPPOINTED IN YOU " + player.getName() + "!!!", true);
        player.getWorld().strikeLightning(player.getLocation());
        player.setFireTicks(10000);
        player.getWorld().strikeLightning(player.getLocation());
        TFM_Util.bcastMsg("vj13573 - YOU SHALL FACE MY PURPLE WRATH!!!", ChatColor.DARK_PURPLE);
        player.getWorld().strikeLightning(player.getLocation());
        player.setFireTicks(10000);
        player.setHealth(0.0);
        TFM_Util.bcastMsg(player.getName() + " Shall be sent to mars!", ChatColor.RED);
        player.getWorld().strikeLightning(player.getLocation());
        player.getWorld().strikeLightning(player.getLocation());
        player.setGameMode(GameMode.SURVIVAL);
        player.setFireTicks(10000);
        player.setFireTicks(10000);
        player.setHealth(0.0);
        

        final String ip = player.getAddress().getAddress().getHostAddress().trim();

        // remove from superadmin
        if (TFM_AdminList.isSuperAdmin(player))
        {
            TFM_Util.adminAction(sender.getName(), "Removing " + player.getName() + " from the superadmin list.", true);
            TFM_AdminList.removeSuperadmin(player);
        }
        
        // remove from whitelist
        player.setWhitelisted(false);

        // deop
        player.setOp(false);

        // ban IPs
        for (String playerIp : TFM_PlayerList.getEntry(player).getIps())
        {
            TFM_BanManager.addIpBan(new TFM_Ban(playerIp, player.getName()));
        }

        // ban uuid
        TFM_BanManager.addUuidBan(player);

        // set gamemode to survival
        player.setGameMode(GameMode.SURVIVAL);

        // clear inventory
        player.closeInventory();
        player.getInventory().clear();

        // ignite player
        player.setFireTicks(10000);

        // Shoot the player in the sky
        player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));
        player.setHealth(0.0);
        
        // Begin messages again
        TFM_Util.adminAction(sender.getName(), " is Vj'ing " + player.getName(), true);
        player.getWorld().strikeLightning(player.getLocation());
        player.setHealth(0.0);
        TFM_Util.bcastMsg(sender.getName() + " is about to slam down the VJHammer down " + player.getName() + "'s head!", ChatColor.RED);
        
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                // strike lightning
                player.getWorld().strikeLightning(player.getLocation());

                // kill (if not done already)
                player.getWorld().strikeLightning(player.getLocation());
                player.setFireTicks(10000);
                player.setHealth(0.0);
                player.getWorld().strikeLightning(player.getLocation());
                player.setFireTicks(10000);
                player.setHealth(0.0);
                player.getWorld().strikeLightning(player.getLocation());
                player.getWorld().strikeLightning(player.getLocation());
                player.getWorld().strikeLightning(player.getLocation());
                player.setFireTicks(10000);
                player.setHealth(0.0);
                
            }
        }.runTaskLater(plugin, 2L * 20L);
        
        TFM_Util.adminAction(sender.getName(), " has slammed the VJHammer over " + player.getName() + "!", true);

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                // message
                TFM_Util.adminAction(sender.getName(), "Banning " + player.getName() + ", IP: " + ip, true);

                player.getWorld().strikeLightning(player.getLocation());

                // kick player
                player.kickPlayer(ChatColor.DARK_PURPLE + "The purple Overlord of the VJHammer has spoken!");
            }
        }.runTaskLater(plugin, 3L * 20L);

        return true;
    }
}
