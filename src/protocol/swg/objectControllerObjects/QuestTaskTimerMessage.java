/*******************************************************************************
 * Copyright (c) 2013 <Project SWG>
 * 
 * This File is part of NGECore2.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Using NGEngine to work with NGECore2 is making a combined work based on NGEngine. 
 * Therefore all terms and conditions of the GNU Lesser General Public License cover the combination.
 ******************************************************************************/
package protocol.swg.objectControllerObjects;

import java.nio.ByteOrder;

import org.apache.mina.core.buffer.IoBuffer;

import protocol.swg.ObjControllerMessage;

public class QuestTaskTimerMessage extends ObjControllerObject {

	private long objectId;
	private int count;
	private int taskId;
	private String questName;
	private String stf;
	
	public QuestTaskTimerMessage(long objectId, String questName, String stf, int count) {
		this.objectId = objectId;
		this.count = count;
		this.questName = questName;
		this.stf = stf;
	}
	
	@Override
	public void deserialize(IoBuffer data) { }

	@Override
	public IoBuffer serialize() {
		byte[] nameBytes = getAsciiString(questName);
		byte[] stfBytes = getUnicodeString(stf);
		IoBuffer buffer = IoBuffer.allocate(24 + nameBytes.length + stfBytes.length).order(ByteOrder.LITTLE_ENDIAN);
		
		buffer.putInt(ObjControllerMessage.QUEST_TASK_TIMER);
		buffer.putLong(objectId);
		buffer.putInt(0);
		
		buffer.put(nameBytes);
		buffer.putInt(taskId);
		buffer.put(stfBytes);
		buffer.putInt(count);
		
		return buffer.flip();
	}

}
