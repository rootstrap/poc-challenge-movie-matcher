import { DefaultTheme } from 'react-native-paper';

import { BLACK, GRAY, SCREEN_BACKGROUND, VIOLET } from 'theme/colors';

export const DEFAULT_THEME = {
  ...DefaultTheme,
  colors: {
    ...DefaultTheme.colors,
    primary: VIOLET,
    disabled: GRAY,
    text: BLACK,
    background: SCREEN_BACKGROUND,
  },
};
