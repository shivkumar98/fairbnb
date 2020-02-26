package com.fdmgroup.FairBnBwebsite.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.fdmgroup.FairBnBwebsite.model.Host;

public interface HostService {
	
	Host getHostById(int HostId); //should be hostId
	
	Host createHost();
	
	Host editHost( Host host );

	List<Host> getAllHosts();
	
	void deleteHost(Host host);
	
	void deleteHostById(int HostId);
	
	Host saveHost(Host host);

}
