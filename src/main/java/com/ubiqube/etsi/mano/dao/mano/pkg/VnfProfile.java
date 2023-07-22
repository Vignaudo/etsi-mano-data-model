/**
 *     Copyright (C) 2019-2023 Ubiqube.
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

import java.io.Serializable;

import jakarta.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@Embeddable
@Getter
@Setter
public class VnfProfile implements Serializable {
	/** Serial. */
	private static final long serialVersionUID = 1L;

	/**
	 * Identifier of the instantiation level of the VNF DF to be used for
	 * instantiation. If not present, the default instantiation level as declared in
	 * the VNFD shall be used.
	 */
	private String instantiationLevel;

	/**
	 * Specifies the service availability level for the VNF instance created from
	 * this profile.
	 */
	private Integer serviceAvailabilityLevel;

	/**
	 * Minimum number of instances of the VNF based on this VNFD that is permitted
	 * to exist for this VnfProfile.
	 */
	private Integer minNumberOfInstances;

	/**
	 * Maximum number of instances of the VNF based on this VNFD that is permitted
	 * to exist for this VnfProfile.
	 */
	private Integer maxNumberOfInstances;

}
