/**
 *     Copyright (C) 2019-2024 Ubiqube.
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
 *     along with this program.  If not, see https://www.gnu.org/licenses/.
 */
package com.ubiqube.etsi.mano.dao.mano.pkg;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@Entity
@Getter
@Setter
public class NfviMaintenanceInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	private ZonedDateTime impactNotificationLeadTime;

	private boolean isImpactMitigationRequested;

	@ElementCollection(fetch = FetchType.EAGER)
	private Set<MigrationType> supportedMigrationType;

	private ZonedDateTime maxUndetectableInterruptionTime;

	private ZonedDateTime minRecoveryTimeBetweenImpacts;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<MaxNumberOfImpactedInstance> maxNumberOfImpactedInstances;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<MinNumberOfPreservedInstance> minNumberOfPreservedInstances;
}
