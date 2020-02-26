package com.fdmgroup.FairBnBwebsite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.FairBnBwebsite.model.Host;
import com.fdmgroup.FairBnBwebsite.repository.HostRepository;

@Service
public class HostServiceImpl implements HostService{
	
	@Autowired
	private HostRepository hostRepository;

	@Override
	public Host getHostById(int HostId) {
		Host host = hostRepository.findById(HostId)
			.orElseThrow(() -> new IllegalArgumentException("Invalid Host ID " + HostId ));
		return host;
	}

	@Override
	public Host createHost() {
		Host host = new Host();
		return host;
	}

	@Override
	public Host editHost(Host host) {
		return hostRepository.save(host);
	}

	@Override
	public List<Host> getAllHosts() {
		return hostRepository.findAll();
	}

	@Override
	public void deleteHost(Host host) {
		hostRepository.delete(host);
	}

	@Override
	public void deleteHostById(int HostId) {
		hostRepository.deleteById(HostId);
	}

	@Override
	public Host saveHost(Host host) {
		return hostRepository.save(host);
	}

}
