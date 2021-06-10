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

import java.io.Serializable;

/**
 *
 * @author Olivier Vignaud <ovi@ubiqube.com>
 *
 */

import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class VnfcResourceInfoVnfcCpInfoEntity implements Serializable {
	/** Serial. */
	private static final long serialVersionUID = 1L;

	@Id
	private String id = null;

	private String cpdId = null;

	private String vnfExtCpId = null;

	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private List<CpProtocolInfoEntity> cpProtocolInfo = null;

	private String vnfLinkPortId = null;

	@ElementCollection(fetch = FetchType.EAGER)
	private Map<String, String> metadata = null;

}
