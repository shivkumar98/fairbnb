package com.fdmgroup.FairBnBwebsite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.FairBnBwebsite.model.Reservation;
import com.fdmgroup.FairBnBwebsite.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	private ReservationRepository reservationRepository;
	

	@Override
	public Reservation getReservationById(int reservationId) {
		return reservationRepository.findById(reservationId)
			.orElseThrow(() -> new IllegalArgumentException("Invalid Reservation ID: " + reservationId));
	}

	@Override
	public Reservation createReservation() {
		Reservation reservation = new Reservation();
		return reservation;
	}

	@Override
	public Reservation editReservation(Reservation reservation) {
		return reservationRepository.save(reservation);
	}

	@Override
	public Reservation saveReservation(Reservation reservation) {
		return reservationRepository.save(reservation);
	}

	@Override
	public List<Reservation> getAllReservations() {
		return reservationRepository.findAll();
	}

	@Override
	public void deleteReservation(Reservation reservation) {
		reservationRepository.delete(reservation);
		
	}

	@Override
	public void deleteRedervationById(int reservationId) {
		reservationRepository.deleteById(reservationId);
		
	}

}
