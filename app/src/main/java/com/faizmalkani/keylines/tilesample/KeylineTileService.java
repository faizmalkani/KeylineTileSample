package com.faizmalkani.keylines.tilesample;

import android.graphics.drawable.Icon;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import android.util.Log;

/**
 * Created by Faiz Malkani on 5/3/2016.
 */
public class KeylineTileService extends TileService
{
    /**
     * Called when the tile is clicked, regardless of its current state
     */
    @Override
    public void onClick()
    {
        super.onClick();
        Tile tile = getQsTile();
        switch (tile.getState())
        {
            case Tile.STATE_ACTIVE:
            {
                setTileState(Tile.STATE_INACTIVE, tile);

                // Code to turn off something, in this case, the service that draws the grid overlay
                // getApplicationContext().stopService(new Intent(this, KeylineGridService.class));

                break;
            }
            case Tile.STATE_INACTIVE:
            {
                setTileState(Tile.STATE_ACTIVE, tile);

                // Code to turn on something, in this case, the service that draws the grid overlay
                // getApplicationContext().startService(new Intent(this, KeylineGridService.class));

                break;
            }
            case Tile.STATE_UNAVAILABLE:
            {
                setTileState(Tile.STATE_UNAVAILABLE, tile);

                // Code to handle cases in which the tile is unavailable

                break;
            }
        }
    }

    /**
     * Called when the tile is added to the QuickSettings pane
     */
    @Override
    public int onTileAdded()
    {
        return super.onTileAdded();
    }

    /**
     * Called when the tile is removed from the QuickSettings pane
     */
    @Override
    public void onTileRemoved()
    {
        super.onTileRemoved();
    }

    /**
     * Called when the tile moves into listening state
     * For example, when the QuickSettings pane is expanded and the tile needs to keep the UI up
     * to date
     */
    @Override
    public void onStartListening()
    {
        super.onStartListening();
    }

    /**
     * Called when the tile moves out of listening state
     * For example, when the QuickSettings pane is collapsed
     */
    @Override
    public void onStopListening()
    {
        super.onStopListening();
    }

    /**
     * Method to set the state of the tile. This example only updates the icon since it's a toggle
     * action and the label remains same, but the label and content description can also be updated
     * by calling tile.setLabel() and tile.setContentDescription()
     * @param tileState The state required to be set on the tile
     * @param tile The Tile object required to be passed during invocation for operation upon
     */
    void setTileState(int tileState, Tile tile)
    {
        switch (tileState)
        {
            case Tile.STATE_ACTIVE:
            {
                Icon icon = Icon.createWithResource(getApplicationContext(), R.drawable.ic_grid_on);
                tile.setIcon(icon);
                tile.setState(Tile.STATE_ACTIVE);
                tile.updateTile();
                break;
            }
            case Tile.STATE_INACTIVE:
            {
                Icon icon = Icon.createWithResource(getApplicationContext(), R.drawable.ic_grid_off);
                tile.setIcon(icon);
                tile.setState(Tile.STATE_INACTIVE);
                tile.updateTile();
                break;
            }
            case Tile.STATE_UNAVAILABLE:
            {
                Icon icon = Icon.createWithResource(getApplicationContext(), R.drawable.ic_grid_off);
                tile.setIcon(icon);
                tile.setState(Tile.STATE_UNAVAILABLE);
                tile.updateTile();
                break;
            }
        }
    }
}
