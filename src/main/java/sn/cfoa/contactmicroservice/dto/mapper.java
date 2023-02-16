package sn.cfoa.contactmicroservice.dto;

import java.util.ArrayList;	
import java.util.List;
import java.util.stream.Collectors;

import sn.cfoa.contactmicroservice.dto.responseDto.CampagneResponseDto;
import sn.cfoa.contactmicroservice.dto.responseDto.ContactResponseDto;
import sn.cfoa.contactmicroservice.dto.responseDto.LeadResponseDto;
import sn.cfoa.contactmicroservice.dto.responseDto.NoteResponseDto;
import sn.cfoa.contactmicroservice.dto.responseDto.OpportuniteResponseDto;
import sn.cfoa.contactmicroservice.dto.responseDto.RendezVousResponseDto;
import sn.cfoa.contactmicroservice.dto.responseDto.TacheResponseDto;
import sn.cfoa.contactmicroservice.model.Campagne;
import sn.cfoa.contactmicroservice.model.Contact;
import sn.cfoa.contactmicroservice.model.Lead;
import sn.cfoa.contactmicroservice.model.Note;
import sn.cfoa.contactmicroservice.model.Opportunite;
import sn.cfoa.contactmicroservice.model.RendezVous;
import sn.cfoa.contactmicroservice.model.Tache;

public class mapper {

	public static NoteResponseDto noteToNoteResponseDto(Note note) {
		NoteResponseDto noteResponseDto = new NoteResponseDto();
		noteResponseDto.setId(note.getId());
		noteResponseDto.setRemarque(note.getRemarque());
		return noteResponseDto;
	}
	
	public static List<NoteResponseDto> notesToNoteResponseDtos(List<Note> notes){
		List<NoteResponseDto> noteResponseDtos = new ArrayList<>();
		for(Note note: notes ) {
			noteResponseDtos.add(noteToNoteResponseDto(note));
		}
		return noteResponseDtos;
	}
	
	public static LeadResponseDto leadToLeadResponseDto(Lead lead) {
		LeadResponseDto leadResponseDto = new LeadResponseDto();
		leadResponseDto.setId(lead.getId());
		leadResponseDto.setNom(lead.getNom());
		leadResponseDto.setPrenom(lead.getPrenom());
		leadResponseDto.setAge(lead.getAge());
		leadResponseDto.setGenre(lead.getGenre());
		leadResponseDto.setProfession(lead.getProfession());
		return leadResponseDto;
	}
	
	public static List<LeadResponseDto> leadsToLeadResponseDtos(List<Lead> leads){
		List<LeadResponseDto> leadResponseDtos = new ArrayList<>();
		for(Lead lead: leads) {
			leadResponseDtos.add(leadToLeadResponseDto(lead));
		}
		return leadResponseDtos;
	}

	public static ContactResponseDto contactToContactResponseDto(Contact contact) {
		ContactResponseDto contactResponseDto = new ContactResponseDto();
		contactResponseDto.setId(contact.getId());
		contactResponseDto.setNom(contact.getNom());
		contactResponseDto.setPrenom(contact.getPrenom());
		contactResponseDto.setGenre(contact.getGenre());
		contactResponseDto.setAdresse(contact.getAdresse());
		contactResponseDto.setTelephone(contact.getTelephone());
		contactResponseDto.setEmail(contact.getEmail());
		contactResponseDto.setType(contact.getType());
		contactResponseDto.setTache(contact.getTaches().stream().map(Tache::getObject).collect(Collectors.toSet()));
		return contactResponseDto;
	}
	
	public static List<ContactResponseDto> contactsToContactResponseDtos(List<Contact> contacts){
		List<ContactResponseDto> contactResponseDtos = new ArrayList<>();
		for(Contact contact: contacts) {
			contactResponseDtos.add(contactToContactResponseDto(contact));
		}
		return contactResponseDtos;
	}
	
	public static RendezVousResponseDto rendezVousToRendezVousResponseDto(RendezVous rendezVous) {
		RendezVousResponseDto rendezVousResponseDto = new RendezVousResponseDto();
		rendezVousResponseDto.setId(rendezVous.getId());
		rendezVousResponseDto.setDate(rendezVous.getDate());
		rendezVousResponseDto.setHeure(rendezVous.getHeure());
		return rendezVousResponseDto;
	}
	
	public static List<RendezVousResponseDto> rendezVousesToRendezVousResponseDtos(List<RendezVous> rendezVouses){
		List<RendezVousResponseDto> rendezVousResponseDtos = new ArrayList<>();
		for(RendezVous rendezVous: rendezVouses) {
			rendezVousResponseDtos.add(rendezVousToRendezVousResponseDto(rendezVous));
		}
		return rendezVousResponseDtos;
	}
	
	public static TacheResponseDto tacheToTacheResponseDto(Tache tache) {
		TacheResponseDto tacheResponseDto = new TacheResponseDto();
		tacheResponseDto.setId(tache.getId());
		tacheResponseDto.setObject(tache.getObject());
		tacheResponseDto.setDateEcheance(tache.getDateEcheance());
		tacheResponseDto.setEtape(tache.getEtape());
		tacheResponseDto.setPriorite(tache.getPriorite());
		
		return tacheResponseDto;
	}
	
	public static List<TacheResponseDto> tachesToTacheResponseDtos(List<Tache> taches){
			List<TacheResponseDto> tacheResponseDtos = new ArrayList<>();
			for(Tache tache: taches) {
				tacheResponseDtos.add(tacheToTacheResponseDto(tache));
			}
			return tacheResponseDtos;
	}
	
	public static OpportuniteResponseDto opportuniteToOpportuniteResponseDto(Opportunite opportunite) {
		OpportuniteResponseDto opportuniteResponseDto = new OpportuniteResponseDto();
		opportuniteResponseDto.setId(opportunite.getId());
		opportuniteResponseDto.setNom(opportunite.getNom());
		opportuniteResponseDto.setType(opportunite.getType());
		opportuniteResponseDto.setEtape(opportunite.getEtape());
		opportuniteResponseDto.setMontant(opportunite.getMontant());
		opportuniteResponseDto.setDate(opportunite.getDate());
		//opportuniteResponseDto.setContactName(opportunite.getContact().getNom());
		return opportuniteResponseDto;
	}
	
	public static List<OpportuniteResponseDto> opportunitesToOpportuniteResponseDtos(List<Opportunite> opportunites){
		List<OpportuniteResponseDto> opportuniteResponseDtos = new ArrayList<>();
		for(Opportunite opportunite: opportunites) {
			opportuniteResponseDtos.add(opportuniteToOpportuniteResponseDto(opportunite));
		}
		return opportuniteResponseDtos;
	}

	public static CampagneResponseDto campagneToCampagneResponseDto(Campagne campagne) {
	
		CampagneResponseDto campagneResponseDto = new CampagneResponseDto();
		campagneResponseDto.setId(campagne.getId());
		campagneResponseDto.setNom(campagne.getNom());
		campagneResponseDto.setDateDebut(campagne.getDateDebut());
		campagneResponseDto.setChiffreAttendue(campagne.getChiffreAttendue());
		campagneResponseDto.setType(campagne.getType());
		campagneResponseDto.setEtape(campagne.getEtape());
		campagneResponseDto.setFin(campagne.getFin());
		List<String> names = new ArrayList<>();
		List<Lead> leads = campagne.getLeads();
		for(Lead lead: leads) {
			names.add(lead.getNom());
		}
		campagneResponseDto.setLeadNames(names);
		return campagneResponseDto;
	}
	
	public static List<CampagneResponseDto> campagnesToCampagneResponseDtos(List<Campagne> campagnes){
		List<CampagneResponseDto> campagneResponseDtos = new ArrayList<>();
		for (Campagne campagne: campagnes) {
			campagneResponseDtos.add(campagneToCampagneResponseDto(campagne));
		}
		return campagneResponseDtos;
	}
	
}
