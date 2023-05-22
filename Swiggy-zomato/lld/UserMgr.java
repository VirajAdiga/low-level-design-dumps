package lld;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class UserMgr {
    private static UserMgr userMgrInstance = null;
    private static ReentrantLock mtx = new ReentrantLock();
    private Map<String, User> usersMap = new HashMap<>();

    private UserMgr() {}

    public static UserMgr getUserMgr() {
        if (userMgrInstance == null) {
            mtx.lock();
            try {
                if (userMgrInstance == null) {
                    userMgrInstance = new UserMgr();
                }
            } finally {
                mtx.unlock();
            }
        }
        return userMgrInstance;
    }

    public void addUser(String pUserName, User pUser) {
        usersMap.put(pUserName, pUser);
    }

    public User getUser(String pUserName) {
        return usersMap.get(pUserName);
    }
}
