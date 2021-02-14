package fr.yugo.discord.events;

import java.util.List;

import fr.yugo.discord.Main;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Invite;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;

public class GuildMemberJoinByInvitEvent extends GuildMemberJoinEvent {

	private Invite invite;
	
	public GuildMemberJoinByInvitEvent(JDA api, long responseNumber, Member member) {
		super(api, responseNumber, member);
		
		List<Invite> ex = Main.invites.get(member.getGuild());
		
		Main.invites.put(member.getGuild(), member.getGuild().retrieveInvites().complete());
		
		for (Invite i : Main.invites.get(member.getGuild())) {
			for (Invite e : ex) {
				if (e.getCode().equalsIgnoreCase(i.getCode())) {
					if (e.getUses() < i.getUses()) {
						invite = i;
						return;
					}
				}
			}
		}
	}
	
	public Invite getInvite() {
		return invite;
	}

}
