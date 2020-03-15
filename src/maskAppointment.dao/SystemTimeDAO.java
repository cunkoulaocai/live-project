package maskAppointment.dao;

import maskAppointment.pojo.SystemTime;;

public interface SystemTimeDAO {
	int getTotal();
    void add(SystemTime bean);
    void update(SystemTime bean);
    void delete(String id);
}
