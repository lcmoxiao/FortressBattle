package core;

import core.room.PlayerInfo;
import core.room.Room;

import java.util.HashMap;


//房间管理中心，也是所有数据的存储中心，所有游戏相关都放在rooms里。
public class RoomCenter {

    static int randomId = 0;//用来给房间赋予id

    static HashMap<Integer, Room> rooms = new HashMap<>();

    //传入 房主的 id，和房间名
    void createRoom(int playerId, String roomName) {
        PlayerInfo pl = new PlayerInfo(playerId);
        Room r = new Room(pl, roomName, randomId);
        rooms.put(randomId, r);
        randomId++;
    }

    boolean joinRoom(int playerId, int roomId) {
        PlayerInfo pl = new PlayerInfo(playerId);
        return rooms.get(roomId).join(pl);
    }


}
