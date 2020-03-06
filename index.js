import {Platform, NativeModules} from 'react-native';

/**
 * Cross-platofrm (iOS and Android) method for Developer Menu
 */
export const open = () => {
  if (Platform.OS === 'android') {
    const {OpenDeveloperMenu} = NativeModules;
    OpenDeveloperMenu.open();
    return;
  }

  const {DevMenu} = NativeModules;
  if (DevMenu) {
    // works in iOS
    DevMenu.show();
    return;
  }
};
