// Return tiles of certain types
public class TileFactory implements TileFactoryInterface{

    public Tile getTile(String tileType){
        if(tileType == null){
            return null;
        }
        if(tileType.equalsIgnoreCase("INACCESSIBLE")){
            return new InaccessibleTile();

        } else if(tileType.equalsIgnoreCase("COMMON")){
            return new CommonTile();

        } else if(tileType.equalsIgnoreCase("NEXUS")){
            return new NexusTile();
        } else if(tileType.equalsIgnoreCase("KOULOU")){
            return new KoulouTile();
        } else if(tileType.equalsIgnoreCase("BUSH")){
            return new BushTile();
        } else if(tileType.equalsIgnoreCase("CAVE")){
            return new CaveTile();
        }

        return null;
    }
}

