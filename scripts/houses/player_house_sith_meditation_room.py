import sys
from services.housing import HouseTemplate
from engine.resources.scene import Point3D

def setup(housingTemplates):
	houseTemplate = HouseTemplate("object/tangible/tcg/series3/shared_structure_deed_sith_meditation_room_deed.iff", "object/building/player/shared_player_house_sith_meditation_room.iff", 3)
	
	houseTemplate.addBuildingSign("object/tangible/sign/player/shared_house_address.iff", Point3D(float(3), float(2.86), float(5.7)))
	houseTemplate.addPlaceablePlanet("tatooine")
	houseTemplate.addPlaceablePlanet("corellia")
	houseTemplate.addPlaceablePlanet("naboo")
	houseTemplate.addPlaceablePlanet("talus")
	houseTemplate.addPlaceablePlanet("rori")
	houseTemplate.addPlaceablePlanet("dantooine")
	houseTemplate.addPlaceablePlanet("lok")
	houseTemplate.setDefaultItemLimit(350)
	houseTemplate.setBaseMaintenanceRate(8)
	
	housingTemplates.put(houseTemplate.getDeedTemplate(), houseTemplate)
	return