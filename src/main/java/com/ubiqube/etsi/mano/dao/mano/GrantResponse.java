/**
 *     Copyright (C) 2019-2020 Ubiqube.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.ubiqube.etsi.mano.dao.mano;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import com.ubiqube.etsi.mano.dao.mano.grant.PlacementConstraint;
import com.ubiqube.etsi.mano.dao.mano.grant.VimConstraint;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Olivier Vignaud <ovi@ubiqube.com>
 *
 */
@Getter
@Setter
@Entity
@EntityListeners(AuditListener.class)
public class GrantResponse implements BaseEntity, Auditable, GrantInterface {
	/** Serial. */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Embedded
	private Audit audit;

	private String vnfdId;

	// 3.3.1
	private String dstVnfdId;

	private String flavourId;

	private String operation;

	private boolean isAutomaticInvocation;

	private String instantiationLevelId;

	// Must be string because VNFM / NFVO are differents.
	private String vnfInstanceId;

	// Must be string because VNFM / NFVO are differents.
	private String vnfLcmOpOccId;

	@Valid
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<VimConnectionInformation> vimConnections;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "grants")
	private Set<ZoneInfoEntity> zones;

	@Valid
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn
	private Set<ZoneGroupInformation> zoneGroups;

	private String computeReservationId;

	private String networkReservationId;

	private String storageReservationId;

	@Valid
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<GrantInformationExt> addResources = new LinkedHashSet<>();

	@Valid
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<GrantInformationExt> tempResources = new LinkedHashSet<>();

	@Valid
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<GrantInformationExt> removeResources = new LinkedHashSet<>();

	@Valid
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private  Set<GrantInformationExt> updateResources = new LinkedHashSet<>();

	@Embedded
	private GrantVimAssetsEntity vimAssets;

	@Valid
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<ExtVirtualLinkDataEntity> extVirtualLinks = new LinkedHashSet<>();

	@Valid
	@OneToMany(mappedBy = "grants", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<ExtManagedVirtualLinkDataEntity> extManagedVirtualLinks = new LinkedHashSet<>();

	@ElementCollection(fetch = FetchType.EAGER)
	private Map<String, String> additionalParams = new HashMap<>();

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<PlacementConstraint> placementConstraints = new LinkedHashSet<>();

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<VimConstraint> vimConstraints = new LinkedHashSet<>();

	private String instanceLink;

	private String lcmLink;

	/**
	 * Flag to say if grants have been, inspected.
	 */
	private Boolean available;

	public void addExtManagedVl(ExtManagedVirtualLinkDataEntity extVl) {
		if (null == extManagedVirtualLinks) {
			extManagedVirtualLinks = new HashSet<>();
		}
		extManagedVirtualLinks.add(extVl);
	}

	public void addZones(ZoneInfoEntity zone) {
		if (null == zones) {
			zones = new HashSet<>();
		}
		zone.setGrants(this);
		zones.add(zone);

	}

	public void addAddResources(GrantInformationExt obj) {
		if (null == addResources) {
			addResources = new LinkedHashSet<>();
		}
		addResources.add(obj);
	}

	public void addRemoveResources(GrantInformationExt obj) {
		if (null == removeResources) {
			removeResources = new LinkedHashSet<>();
		}
		removeResources.add(obj);
	}

}
